import {Ride} from "../model/ride.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class RideService {
  private baseUrl = '/api/bike-rides/rides';

  constructor(private http: HttpClient) {
  }

  getRideList(): Observable<Ride[]> {
    return this.http.get<Ride[]>(`${this.baseUrl}`);
  }

  updateRide(ride: Ride): Observable<Ride> {
    if (!ride.id) {
      return this.http.post<Ride>(`${this.baseUrl}`, ride);
    } else {
      return this.http.put<Ride>(`${this.baseUrl}/${ride.id}`, ride);
    }
  }
}
