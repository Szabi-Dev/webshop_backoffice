import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RolePageComponent} from './pages/role-page/role-page.component'
import {UserPageComponent} from './pages/user-page/user-page.component'


const routes: Routes = [
  {path: 'role', component: RolePageComponent},
  {path: 'user', component: UserPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
