import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

import { Observable } from 'rxjs';
import { distinct, distinctUntilChanged, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ppid } from 'process';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = environment.API;

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API}/products`).pipe(
      distinctUntilChanged((prev, curr) => prev.filter(p => p.productName) !== curr.filter(c => c.productName))
    );
  }

  getProductsByStack(name: string) {
    return this.myFilter('stack', name);
  }

  getProductsByTargetMarket(name: string) {
    return this.myFilter('targetMarket', name);
  }

  private myFilter(tableName: string, name: string) {
    return this.http.get<Product[]>(`${this.API}/products`).pipe(
      map((products: Product[]) => products.filter(p => {
        if (tableName == 'stack') {
          for (let i = 0; i < p.stack.length; i++)
            if (p.stack[i].name.toLowerCase().indexOf(name.toLowerCase()) > -1)
              return p;
        } else if (tableName == 'targetMarket') {
          for (let i = 0; i < p.targetMarket.length; i++)
            if (p.targetMarket[i].name.toLowerCase().indexOf(name.toLowerCase()) > -1)
              return p;
        } else {
          alert("Erro ao carregar produtos filtrados, tente novamente!");
        }
      }))
    );
  }
}
