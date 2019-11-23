import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Place } from "../modules/models/place";
import {Cinema} from "../modules/models/cinema";


@Injectable()
// Data service
export class PlaceService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getPlaces(): Observable<Place[]> {
    return this.http.get<Place[]>('/api/place');
  }

  savePlace(place: Place): Observable<Place> {
    return this.http.post<Place>('/api/place', place);
  }

  deletePlace(idPlace: number): Observable<void> {
    return this.http.delete<void>('/api/place/' + idPlace);
  }

  updatePlace(idPlace: number): Observable<void> {
    return this.http.post<void>('/api/place/update-place', idPlace);
  }

  getPlaceById(idPlace: number): Observable<Place> {
    return this.http.get<Place>('/api/place/' + idPlace);
  }

}
