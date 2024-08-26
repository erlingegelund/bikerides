import {Component, OnDestroy, OnInit} from '@angular/core';
import {AsyncPipe, DatePipe, NgForOf} from "@angular/common";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {Ride} from "../../model/ride.model";
import {RideService} from "../../service/ride.service";
import {ModelService} from "../../service/model.service";
import {MakeService} from "../../service/make.service";
import {Model} from "../../model/model.model";
import {Make} from "../../model/make.model";
import {BehaviorSubject, filter, map, Observable, of} from "rxjs";

@Component({
  selector: 'app-rides',
  standalone: true,
  imports: [
    DatePipe,
    MatIcon,
    MatIconButton,
    NgForOf,
    AsyncPipe
  ],
  templateUrl: './rides.component.html',
  styleUrl: './rides.component.scss'
})
export class RidesComponent implements OnInit, OnDestroy {
  rides: Ride[] = [];
  private models = new BehaviorSubject<Model[]>([]);
  private makes = new BehaviorSubject<Make[]>([]);
  private loadingModels = false;
  private loadingMakes = false;

  constructor(private rideService: RideService, private modelService: ModelService, private makeService: MakeService) { }

  ngOnInit(): void {
  }

  ngOnDestroy() {
  }

  truncateWithEllipsis(text: string | undefined) {
    if (text === undefined) {
      return '';
    }
    return text.length > 20 ? text.substring(0, 20) + '...' : text;
  }

  private loadModels() {
    if (this.loadingModels) {
      return;
    }
    this.loadingModels = true;
    this.modelService.getModelList().subscribe(data => {
      this.models.next(data);
      this.loadingModels = false;
    });
  }

  getMake(modelId: number | undefined): Observable<string> {
    return of('');
    //this.models.pipe(map(models => models.filter(m => m.id === modelId), map(model => this.getMakeName(model.makeId)));
  }

  getModelName(modelId: number | undefined): Observable<string> {
      return of('');
  }

}
