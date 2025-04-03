// App.jsx
import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, BrowserRouter, Navigate } from "react-router-dom";
import Home from "./Component/SharedComponent/Home";
import Login from "./Component/UserComponent/Login";
import Register from "./Component/UserComponent/Register";
import ServiceComp from "./Component/SharedComponent/ServiceComp";
import ACRepair from "./Component/ServiceComponent/ACRepair";
import ACInfoCards from "./Component/ServiceComponent/ACInfoCards";
import Issue from "./Component/ServiceComponent/Issue";
import Order from "./Component/ServiceComponent/Order";
import Laptop from "./Component/ServiceComponent/Laptop";
import Microwave from "./Component/ServiceComponent/Microwave";
import Geyser from "./Component/ServiceComponent/Geyser";
import Television from "./Component/ServiceComponent/Television";
import Washing from "./Component/ServiceComponent/Washing";
import Navbar from "./Component/SharedComponent/Navbar";
import UserOrder from "./Component/OrderComponent/UserOrder";
import AdminLogin from "./Component/AdminComponent/AdminLogin";
import AdminHome from "./Component/AdminComponent/AdminHome";
import AllOrders from "./Component/OrderComponent/AllOrders";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [user, setUser] = useState(null);
 const[admin,setAdmin]=useState(null);
  return (
    <div>
      <BrowserRouter>
        <Navbar admin={admin} user={user}  isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn}/>
        <Routes>
          <Route path="/" element={<Home admin={admin} user={user} setUser={setUser} isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} />} />
          <Route path="/Home" element={<Home isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} />} />
          <Route path="/login" element={<Login isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} setUser={setUser} />} />
          <Route path="/register" element={<Register />} />
          <Route path="/ServiceComp" element={<ServiceComp />} />
          <Route path="/ACRepair" element={<ACRepair />} />
          <Route path="/ACInfoCards" element={<ACInfoCards />} />
          <Route path="/Issue" element={<Issue />} />
          <Route path="/Order" element={user ? <Order user={user} /> : <Navigate to="/login" />} />
          <Route path="/Laptop" element={<Laptop />} />
          <Route path="/Microwave" element={<Microwave />} />
          <Route path="/Geyser" element={<Geyser />} />
          <Route path="/Television" element={<Television />} />
          <Route path="/UserOrder" element={user ?<UserOrder  username={user.username} userid={user.id}/> : <Navigate to="/login" />}  />
           <Route path="/adminlogin" element={<AdminLogin isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} setAdmin={setAdmin}/>  }/>
           <Route path="/adminhome" element={<AdminHome />} />
           <Route path="/allorders" element={<AllOrders />} />
           
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
