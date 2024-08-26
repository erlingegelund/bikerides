import { Routes } from '@angular/router';
import {RidesComponent} from "./components/rides/rides.component";
import {CategoriesComponent} from "./components/categories/categories.component";
import {MakesComponent} from "./components/makes/makes.component";
import {ModelsComponent} from "./components/models/models.component";

export const routes: Routes = [
  { path: 'rides', component: RidesComponent },
  { path: '', redirectTo: '/rides', pathMatch: 'full' },
  { path: 'categories', component: CategoriesComponent },
  { path: 'makes', component: MakesComponent },
  { path: 'models', component: ModelsComponent },
];
