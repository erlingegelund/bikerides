import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakesComponent } from './makes.component';

describe('MakesComponent', () => {
  let component: MakesComponent;
  let fixture: ComponentFixture<MakesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MakesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MakesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
