import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Stack } from '../models/stack.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = `${environment.API}/products`;

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API);
  }

  getProductsByStack(name: string) {
    return this.http.get<Product[]>(this.API).pipe(
      map((products: Product[]) => products.filter(p => p.stack.filter(s => s.name == name)))
    );
  }

  getProductsByTargetMarket(name: string) {
    return this.http.get<Product[]>(this.API).pipe(
      map((products: Product[]) => products.filter(p => p.targetMarket.map(t => t.name == name)))
    );
  }

  // Exemplo
  // getCidadesBr(idEstado: number) {
  //   return this.http.get<CidadeBr[]>('assets/dados/cidadesbr.json').pipe(
  //     map((cidades: CidadeBr[]) => cidades.filter(c => c.estado == idEstado))
  //   );
  // }

}
