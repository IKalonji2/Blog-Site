import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { select, Store } from '@ngrx/store';
import { selectUser } from '../../store/store.selectors';
import { userLoggedIn } from '../../store/store.actions';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
})
export class NavBarComponent implements OnInit {
  constructor(private store: Store) {}

  user: User = { username: '' };

  ngOnInit(): void {
    let shop = this.store.pipe(select(selectUser));
    shop.subscribe((s) => {
      if (!s) {
        return;
      } else {
        this.user = s;
      }
    });
  }

  async getUser(): Promise<void> {
    this.store.dispatch(userLoggedIn());
    let shop = this.store.pipe(select(selectUser));
    shop.subscribe((s) => {
      if (!s) {
        return;
      } else {
        this.user = s;
      }
    });
  }
}
