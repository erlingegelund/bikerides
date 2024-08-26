import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category.model";
import {NgForOf} from "@angular/common";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [
    NgForOf,
    MatIcon,
    MatIconButton
  ],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.scss',
})
export class CategoriesComponent implements OnInit {
  categories: Category[] = [];

  constructor(private categoriesService: CategoryService) { }

  ngOnInit(): void {
    this.categoriesService.getCategoryList().subscribe(data => {
      this.categories = data;
    });
  }
}
