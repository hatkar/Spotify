import { Component } from '@angular/core';
import { fontAwesomeIcons } from '../../shared/font-awesome-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-library',
  standalone: true,
  imports: [FontAwesomeModule],
  templateUrl: './library.component.html',
  styleUrl: './library.component.scss'
})
export class LibraryComponent {

}
