import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'

import { CadastroItemComponent } from './cadastro-item/cadastro-item.component';
import { SharedModule } from './../shared/shared.module';
import { ItemRoutingModule } from './item-routing.module';
import { ListagemItensComponent } from './listagem-itens/listagem-itens.component';



@NgModule({
  declarations: [
    ListagemItensComponent,
    CadastroItemComponent
  ],
  imports: [
    CommonModule,
    ItemRoutingModule,
    SharedModule,
    ReactiveFormsModule,
  ]
})
export class ItemModule { }
