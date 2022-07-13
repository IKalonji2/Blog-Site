import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ViewArticleComponent } from './components/view-article/view-article.component';
import { LandingComponentComponent } from './components/landing-component/landing-component.component';

const routes: Routes = [
  { path: 'article', component: ViewArticleComponent },

  { path: '', component: LandingComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
