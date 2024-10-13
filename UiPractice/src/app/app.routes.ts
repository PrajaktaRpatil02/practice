import { Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AddressComponent } from './address/address.component';
import { HomeComponent } from './home/home.component';
import { BooksComponent } from './books/books.component';
import { AddbookComponent } from './addbook/addbook.component';

export const routes: Routes = [
    {path:"",component:HomeComponent},
    {path:"register",component:UserComponent},
    {path:"address",component:AddressComponent},
    {path:"book",component:BooksComponent},
    {path:"add/book",component:AddbookComponent}
];
