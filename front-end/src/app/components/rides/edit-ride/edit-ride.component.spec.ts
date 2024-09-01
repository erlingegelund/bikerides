import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRideComponent } from './edit-ride.component';

describe('EditRideComponent', () => {
  let component: EditRideComponent;
  let fixture: ComponentFixture<EditRideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditRideComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditRideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
