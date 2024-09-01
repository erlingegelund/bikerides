import {Component, inject, signal} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent, MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";
import {Ride} from "../../../model/ride.model";
import {MatFormField, MatHint, MatLabel, MatOption, MatSelect} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Make} from "../../../model/make.model";
import {Model} from "../../../model/model.model";
import {MatInput} from "@angular/material/input";
import {MatIcon} from "@angular/material/icon";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";

export interface EditRideData {
  makeId: number;
  ride: Ride;
  makes: Make[];
  models: Model[];
}

@Component({
  selector: 'app-edit-ride',
  standalone: true,
  imports: [
    MatDialogContent,
    MatDialogTitle,
    MatButton,
    MatDialogClose,
    MatDialogActions,
    MatSelect,
    MatLabel,
    MatFormField,
    FormsModule,
    MatOption,
    MatInput,
    MatIcon,
    MatHint,
    ReactiveFormsModule,
    MatDatepickerToggle,
    MatDatepicker,
    MatDatepickerInput,
  ],
  templateUrl: './edit-ride.component.html',
  styleUrl: './edit-ride.component.scss'
})
export class EditRideComponent {
  readonly dialogRef = inject(MatDialogRef<EditRideComponent>);
  readonly data = inject<EditRideData>(MAT_DIALOG_DATA);
  readonly ride = signal(this.data.ride);


  cancel() {
    this.dialogRef.close();
  }
}
