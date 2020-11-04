import { Stack } from './iStack.model';
import { Target } from './iTarget.model';

export interface Product {
    id: number;
    productName: string;
    description: string;
    targetMarket: Target[];
    stack: Stack[];
}