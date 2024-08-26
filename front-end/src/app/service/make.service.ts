import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Make} from "../model/make.model";

@Injectable()
export class MakeService {
  private baseUrl = '/api/v1/makes';

  constructor(private http: HttpClient) {
  }

  getMakeList(): Observable<Make[]> {
    return this.http.get<Make[]>(`${this.baseUrl}`);
  }

  getMakeById(id: number): Observable<Make> {
    return this.http.get<Make>(`${this.baseUrl}/${id}`);
  }

  createMake(make: Make): Observable<Make> {
    return this.http.post<Make>(`${this.baseUrl}`, make);
  }

  updateMake(id: number, make: Make): Observable<Make> {
    return this.http.put<Make>(`${this.baseUrl}/${id}`, make);
  }
}
