import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
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
