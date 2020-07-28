import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{AdminComponent} from '../app/admin/admin.component';
import { HeaderComponent } from './header/header.component';
import {UploadedFilesComponent} from './uploaded-files/uploaded-files.component';
import {PassTrComponent} from './pass-tr/pass-tr.component';
import {FailedTrComponent} from './failed-tr/failed-tr.component';


const routes: Routes = [
  {path:'header', component:HeaderComponent},
  {path:'admin', component:AdminComponent},
  {path:'uploadedfile', component:UploadedFilesComponent},
  {path:'passedTr', component:PassTrComponent},
  {path:'failedTr',component:FailedTrComponent},
  {path:'', redirectTo:'/header', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
