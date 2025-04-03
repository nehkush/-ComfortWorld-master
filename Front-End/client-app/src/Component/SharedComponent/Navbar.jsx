import React from "react";
import { Link, useLocation } from "react-router-dom"; // Import Link from react-router-dom
import { Nav, Button } from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import "@fortawesome/fontawesome-free/css/all.min.css";

function Navbar({ isLoggedIn, setIsLoggedIn, user, admin }) {
  const location = useLocation();
  const name = user ? user.name : null;
  const adminname = admin ? admin.name : null; // Check if admin is not null
  const handleLogout = () => {
    // Handle logout logic here
    setIsLoggedIn(false); // Set isLoggedIn to false upon logout
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-dark ">
        <div className="container-fluid">
          <Link className="navbar-brand text-white fw-bold fs-4" to="/">
            Comfort World🌍
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className={`nav-item ${location.pathname === '/' ? 'active' : ''}`}>
                <Link className="nav-link text-white" to="/Home">
                  <i className="fas fa-home"></i> Home
                </Link>
              </li>
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle text-white"
                  href="#"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  <i className="fas fa-filter"></i> Services
                </a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li>
                    <Link className="dropdown-item" to="/ServiceComp">
                      Electronics
                    </Link>
                  </li>
                  <li>
                    <Link className="dropdown-item" to="/ServiceComp">
                      Cleaning
                    </Link>
                  </li>
                </ul>
              </li>
            </ul>
            <div className="d-flex align-items-center">
              {!isLoggedIn && (
                <div>
                  {location.pathname !== '/adminlogin' && (
                    <Link to="/adminlogin">
                      <button className="btn btn-outline-primary me-2">
                        <i className="fas fa-sign-in-alt ml-1"></i> AdminPortal
                      </button>
                    </Link>
                  )}
                  <Link to="/register">
                    <button className="btn btn-outline-secondary">
                      <i className="fas fa-user"></i> Register
                    </button>
                  </Link>
                  <Link to="/login">
                    <button className="btn btn-outline-primary me-2">
                      <i className="fas fa-sign-in-alt ml-1"></i> User Login
                    </button>
                  </Link>
                </div>
              )}
              {isLoggedIn && (
                <div>
                  <Link to="/">
                    <button onClick={handleLogout} className="btn btn-outline-primary me-2">
                      <i className="fas fa-sign-in-alt ml-1"></i> SignOut
                    </button>
                  </Link>
                  <Link to="/UserOrder">
                    <button className="btn btn-outline-primary me-2">
                      <i className="fas fa-sign-in-alt ml-1"></i> Cart
                    </button>
                  </Link>
                  <span className="fw-bold text-success">{name}</span>
                </div>
              )}
              {!isLoggedIn && !admin && (
                <div>
                  <span className="fw-bold text-success">{adminname}</span>
                </div>
              )}
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}

export default Navbar;
