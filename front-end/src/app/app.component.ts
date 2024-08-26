import {Component} from '@angular/core';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatMenu, MatIconButton, MatMenuTrigger, MatIcon, MatMenuItem, MatButton, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'bike-rides';

  constructor(private router: Router) {
  }

  public showMenuItem(menuItemName: string): boolean {
    const route = this.router.url;
    return route.substring(1) !== menuItemName;
  }
}
