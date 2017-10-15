import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {

  listActivities = ['surf', 'voile', 'plage', 'ski', 'wake',
    'vélo', 'course à pied'];
  selectedActivity = null;
  userChoices = new Set();

  constructor() {}

  ngOnInit() {
  }

  AddActivity() {
    this.userChoices.add(this.selectedActivity);
    this.selectedActivity = null;
  }

  isValidButton() {
    return this.selectedActivity != null;
  }

}
