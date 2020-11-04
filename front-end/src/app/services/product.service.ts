import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Product} from '../models/product.model';

import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {Stack} from '../models/stack.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url = './assets/dados/gubee-teste.json';

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);
  }

  getStacks(name: string) {
  }

  // Exemplo
  // getCidadesBr(idEstado: number) {
  //   return this.http.get<CidadeBr[]>('assets/dados/cidadesbr.json').pipe(
  //     map((cidades: CidadeBr[]) => cidades.filter(c => c.estado == idEstado))
  //   );
  // }

}
