import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserPageComponent } from './user-page/user-page.component';
import { RolePageComponent } from './role-page/role-page.component';



@NgModule({
  declarations: [UserPageComponent, RolePageComponent],
  imports: [
    CommonModule
  ],
  exports: [UserPageComponent, RolePageComponent]
})
export class PagesModule { }
