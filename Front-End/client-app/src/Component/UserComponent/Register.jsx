import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import {
  validateUsername,
  validateEmail,
  validatePhoneNumber,
  validateAge,
  validateAddress,
  validatePassword,
} from "../../Js/validateRegistrationForm";
import "../../Css/RegisterCss.css";

function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const [password, setPassword] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [age, setAge] = useState("");
  const [errors, setErrors] = useState({
    name: "",
    email: "",
    contactNo: "",
    age: "",
    address: "",
    password: "",
  });
  const navigate = useNavigate(); // Initialize navigate hook

  const url = "http://localhost:8080";

  const RegisterUserData = (e) => {
    e.preventDefault();

    // Validation
    let newErrors = {
      name: !validateUsername(name)
        ? "Invalid username. Please enter letters and spaces only."
        : "",
      email: !validateEmail(email)
        ? "Invalid email address. Please enter a valid email."
        : "",
      contactNo: !validatePhoneNumber(contactNo)
        ? "Invalid phone number. Please enter numbers only. with 10 digits"
        : "",
      age: !validateAge(age) ? "Invalid age. Please enter numbers only." : "",
      address: !validateAddress(address)
        ? "Invalid address. Please enter alphanumeric characters and basic symbols."
        : "",
      password: !validatePassword(password)
        ? "Invalid password. Password must be at least 6 characters long."
        : "",
    };

    setErrors(newErrors);

    // Check if any validation error exists
    if (Object.values(newErrors).some((error) => error !== "")) {
      return;
    }

    // If all validations pass, proceed with form submission
    axios
      .post(`${url}/users`, {
        name,
        email,
        contactNo,
        age,
        address,
        password,
      })
      .then((response) => {
        const result = response.data;
        // Handle the result as needed
        window.alert("Registration Successful.. ");
        navigate("/login");
      });
  };

  return (
    <div
      className="register-container d-flex justify-content-center align-items-center"
      style={{
        backgroundImage: `url('https://source.unsplash.com/1920x1080/?nature')`, // Replace with your desired background image URL
        backgroundSize: "cover",
        minHeight: "100vh",
      }}
    >
      <div className="card" style={{ width: "400px", background: "rgba(255, 255, 255, 0.8)", marginRight: "auto" }}>
        <div className="card-body">
          <h5 className="card-title text-center mb-4">Registration Form</h5>
          <form onSubmit={RegisterUserData}>
            <div className="mb-3">
              <label htmlFor="username" className="form-label">
                Username
              </label>
              <input
                required
                type="text"
                className={`form-control ${errors.name ? "is-invalid" : ""}`}
                id="username"
                placeholder="Enter your Username"
                onChange={(e) => setName(e.target.value)}
              />
              <div className="invalid-feedback">{errors.name}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                Email address
              </label>
              <input
                required
                type="email"
                className={`form-control ${errors.email ? "is-invalid" : ""}`}
                id="email"
                placeholder="Enter your Email"
                onChange={(e) => setEmail(e.target.value)}
              />
              <div className="invalid-feedback">{errors.email}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="contact_no" className="form-label">
                Contact Number
              </label>
              <input
                required
                type="tel"
                className={`form-control ${
                  errors.contactNo ? "is-invalid" : ""
                }`}
                id="contact_no"
                placeholder="Enter your Phone Number"
                onChange={(e) => setContactNo(e.target.value)}
              />
              <div className="invalid-feedback">{errors.contactNo}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="age" className="form-label">
                Age
              </label>
              <input
                required
                type="number"
                className={`form-control ${errors.age ? "is-invalid" : ""}`}
                id="age"
                placeholder="Enter your Age"
                onChange={(e) => setAge(e.target.value)}
              />
              <div className="invalid-feedback">{errors.age}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="address" className="form-label">
                Address
              </label>
              <input
                required
                type="text"
                className={`form-control ${
                  errors.address ? "is-invalid" : ""
                }`}
                id="address"
                placeholder="Enter your Address"
                onChange={(e) => setAddress(e.target.value)}
              />
              <div className="invalid-feedback">{errors.address}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                required
                type="password"
                className={`form-control ${
                  errors.password ? "is-invalid" : ""
                }`}
                id="password"
                placeholder="Enter your Password"
                onChange={(e) => setPassword(e.target.value)}
              />
              <div className="invalid-feedback">{errors.password}</div>
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Register
            </button>
          </form>
          <div className="mt-3 text-center">
            Already have an account?{" "}
            <Link to="/login" className="text-primary">
              Login
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
