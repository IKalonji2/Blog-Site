import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ViewArticleComponent } from './components/view-article/view-article.component'

import { CommonModule } from '@angular/common';
import { AddArticleComponent } from './add-article/add-article.component';
import { ProfileComponent } from './profile/profile.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {
    path: "add-article",
    component: AddArticleComponent
  },
  {
    path: "profile",
    component: ProfileComponent
  },
  {
    path: "logout",
    component: LogoutComponent
  },
  { 
    path: 'article', 
    component: ViewArticleComponent 
  }

]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

