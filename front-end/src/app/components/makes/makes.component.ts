import {Component, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {DatePipe, NgForOf} from "@angular/common";
import {Make} from "../../model/make.model";
import {MakeService} from "../../service/make.service";

@Component({
  selector: 'app-makes',
  standalone: true,
  imports: [
    MatIcon,
    MatIconButton,
    NgForOf,
    DatePipe
  ],
  templateUrl: './makes.component.html',
  styleUrl: './makes.component.scss'
})
export class MakesComponent implements OnInit {
  makes: Make[] = [];

  constructor(private makeService: MakeService) { }

  ngOnInit(): void {
    this.makeService.getMakeList().subscribe(data => {
      this.makes = data;
    });
  }


  asDate(established: string | undefined): Date {
    return established ? new Date(established+'T00:00:00.000Z') : new Date();
  }

  truncateWithEllipsis(text: string | undefined) {
    if (text === undefined) {
      return '';
    }
    return text.length > 20 ? text.substring(0, 20) + '...' : text;
  }
}
