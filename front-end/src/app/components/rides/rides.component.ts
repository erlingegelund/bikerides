import {Component, inject, OnInit} from '@angular/core';
import {AsyncPipe, DatePipe, NgForOf} from "@angular/common";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {Ride} from "../../model/ride.model";
import {RideService} from "../../service/ride.service";
import {ModelService} from "../../service/model.service";
import {MakeService} from "../../service/make.service";
import {Model} from "../../model/model.model";
import {Make} from "../../model/make.model";
import {filter, forkJoin} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {EditRideComponent} from "./edit-ride/edit-ride.component";

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
export class RidesComponent implements OnInit {
  rides: Ride[] = [];
  private models: Model[] = [];
  private makes: Make[] = [];

  private readonly rideService = inject(RideService);
  private readonly modelService = inject(ModelService);
  private readonly makeService =  inject(MakeService);
  private readonly dialogService = inject(MatDialog);

  ngOnInit(): void {
    forkJoin([this.modelService.getModelList(), this.makeService.getMakeList(), this.rideService.getRideList()])
      .subscribe(([models, makes, rides]) => {
        this.models = models;
        this.makes = makes;
        this.rides = rides;
    });
  }

  truncateWithEllipsis(text: string | undefined) {
    if (text === undefined) {
      return '';
    }
    return text.length > 20 ? text.substring(0, 20) + '...' : text;
  }

  getMake(modelId: number | undefined): string {
    const makeId = this.models.find(model => model.id === modelId)?.makeId;
    if (!makeId) {
      return '';
    }
    return this.makes.find(make => make.id === makeId)?.name || '';
  }

  getModelName(modelId: number | undefined): string {
      return this.models.find(model => model.id === modelId)?.name || '';
  }

  edit(ride: Ride) {
    console.log('edit ride', JSON.stringify(ride));
    const makeId = this.models.find(model => model.id === ride.modelId)?.makeId;
    const ref = this.dialogService.open(
      EditRideComponent,
      {data: {makeId, ride, makes: this.makes, models: this.models}});
    ref.afterClosed()
      .pipe(filter(ride => !!ride))
      .subscribe((result: Ride) => {
        this.rideService.updateRide(result).subscribe(() => {
          this.rides = this.rides.map(r => r.id === result.id ? result : r);
        });
      });
  }

  newRide() {
    const ride = {startedAt: new Date(), own: false, distance: 0} as Ride;
    this.edit(ride);
  }
}
