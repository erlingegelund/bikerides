import {Ride} from "../model/ride.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class RideService {
  private baseUrl = '/api/v1/rides';

  constructor(private http: HttpClient) {
  }

  getRideList(): Observable<Ride[]> {
    return this.http.get<Ride[]>(`${this.baseUrl}`);
  }
}
