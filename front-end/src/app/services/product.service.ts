import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/iProduct.model';

import { take } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url = 'http://localhost:3000/products'; // api rest fake

  constructor(private http: HttpClient) { }

  getProducts() {
    return this.http.get<Product[]>(this.url).pipe(take(1));
  }

  // Exemplo
  // getCidadesBr(idEstado: number) {
  //   return this.http.get<CidadeBr[]>('assets/dados/cidadesbr.json').pipe(
  //     map((cidades: CidadeBr[]) => cidades.filter(c => c.estado == idEstado))
  //   );
  // }

}
