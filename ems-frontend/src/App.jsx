import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Hello from './Hello'
// use BrowserRouter to add routes from specific request

function App() {
  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
        {/* //http:localhost:3000 i.e root url  */}
        <Route path='/' element= {<ListEmployeeComponent/>}></Route>
        {/* //for listing employyes */}
        <Route path='/employees' element = {<ListEmployeeComponent/>}></Route>
      </Routes>
      
      <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
