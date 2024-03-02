
import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import { Groups } from './pagesStudent/Groups';
import { Home } from './pagesStudent/Home';
import { Students } from './pagesStudent/Students';
import { AddGroup } from './pagesStudent/AddGroup';
import { LoginSignup } from './Components/LoginSignup/LoginSignup';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route index element={<LoginSignup/>}/>
          <Route path='/home' element={<Home />}/> 
          <Route path='/group' element={<Groups />}/>
          <Route path='/addStudent' element={<Students/>}/>
          <Route path='/addGroup' element={<AddGroup/>}/>
          <Route path='*' element={<LoginSignup/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
