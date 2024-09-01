import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Model} from "../model/model.model";
import {Observable} from "rxjs";

@Injectable({providedIn: 'root'})
export class ModelService {
  private baseUrl = '/api/bike-rides/models';

  constructor(private http: HttpClient) { }

  getModelList(): Observable<Model[]> {
    return this.http.get<Model[]>(this.baseUrl);
  }

  getModelById(id: number): Observable<Model> {
    return this.http.get<Model>(`${this.baseUrl}/${id}`);
  }

  createModel(model: Model): Observable<Model> {
    return this.http.post<Model>(this.baseUrl, model);
  }

  updateModel(id: number, model: Model): Observable<Model> {
    return this.http.put<Model>(`${this.baseUrl}/${id}`, model);
  }
}
