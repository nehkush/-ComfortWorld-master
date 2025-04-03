// OrderForm.jsx

import React, { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import validateOrderForm from "../../Js/OrderValidation";
import "../../Css/OrderForm.css"; // Add the appropriate CSS file if needed
import { useNavigate } from "react-router-dom";

function Order({user}) {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [state, setState] = useState("");
  const [pincode, setPincode] = useState("");
  const [city, setCity] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const [productCategory, setProductCategory] = useState("");
  const [issueDescription, setIssueDescription] = useState("");
  const [payment, setPayment] = useState("");
  const [orderDate, setOrderDate] = useState(""); // New state for order date
  const [errors, setErrors] = useState({});
  const [userid, setUserId] = useState();
  const url = "http://localhost:8080"; // Update the API endpoint
    const navigate=useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    setUserId(user.id);

    const data = {
      name,
      address,
      state,
      pincode,
      city,
      mobileNumber,
      productCategory,
      issueDescription,
      payment,
      orderDate,

    };
      
    const { isValid, errors: validationErrors } = validateOrderForm(data);

    if (isValid) {
      axios
        .post(`${url}/orders/${userid}`, data) // Update the endpoint
        .then((response) => {
          const result = response.data;

          window.alert("Order submitted Successfully... ");
          navigate("/home"); // Update the redirect path
        })
        .catch((error) => {
          console.error("Error in form submission:", error);
        });
    } else {
      setErrors(validationErrors);
    }
  };

  return (
    <div>
      <div className="d-flex align-items-center justify-content-center">
        <div className="card" style={{ width: "600px" }}>
          <div className="card-body">
            <h5 className="card-title text-center mb-4">Order Form</h5>
            <form onSubmit={handleSubmit}>
              {/* Left Column: Personal Information */}
              <div className="row mb-3">
                <div className="col-md-6">
                  <label htmlFor="name" className="form-label">
                    Name
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.name ? "is-invalid" : ""
                    }`}
                    id="name"
                    placeholder="Enter your name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.name}</div>
                </div>

                {/* Add other fields for personal information */}
                {/* Example: Mobile Number */}
                <div className="col-md-6">
                  <label htmlFor="mobileNumber" className="form-label">
                    Mobile Number
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.mobileNumber ? "is-invalid" : ""
                    }`}
                    id="mobileNumber"
                    placeholder="Enter your mobile number"
                    value={mobileNumber}
                    onChange={(e) => setMobileNumber(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.mobileNumber}</div>
                </div>
              </div>
              {/* New field for Order Date */}
              <div className="mb-3">
                <label htmlFor="orderDate" className="form-label">
                  Order Date
                </label>
                <input
                  type="date"
                  className={`form-control ${
                    errors.orderDate ? "is-invalid" : ""
                  }`}
                  id="orderDate"
                  value={orderDate}
                  onChange={(e) => setOrderDate(e.target.value)}
                  required
                />
                <div className="invalid-feedback">{errors.orderDate}</div>
              </div>

              {/* Right Column: Address and Order Details */}
              <div className="row mb-3">
                <div className="col-md-6">
                  <label htmlFor="address" className="form-label">
                    Address
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.address ? "is-invalid" : ""
                    }`}
                    id="address"
                    placeholder="Enter your address"
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.address}</div>
                </div>

                {/* Add other fields for address and order details */}
                {/* Example: City */}
                <div className="col-md-6">
                  <label htmlFor="city" className="form-label">
                    City
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.city ? "is-invalid" : ""
                    }`}
                    id="city"
                    placeholder="Enter your city"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.city}</div>
                </div>
              </div>

              {/* Additional fields for address and order details */}
              {/* Example: State */}
              <div className="row mb-3">
                <div className="col-md-6">
                  <label htmlFor="state" className="form-label">
                    State
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.state ? "is-invalid" : ""
                    }`}
                    id="state"
                    placeholder="Enter your state"
                    value={state}
                    onChange={(e) => setState(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.state}</div>
                </div>

                {/* Example: Pincode */}
                <div className="col-md-6">
                  <label htmlFor="pincode" className="form-label">
                    Pincode
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.pincode ? "is-invalid" : ""
                    }`}
                    id="pincode"
                    placeholder="Enter your pincode"
                    value={pincode}
                    onChange={(e) => setPincode(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.pincode}</div>
                </div>
              </div>

              <div className="row mb-3">
                <div className="col-md-6">
                  <label htmlFor="productCategory" className="form-label">
                    Product Category
                  </label>
                  <select
                    className={`form-control ${
                      errors.productCategory ? "is-invalid" : ""
                    }`}
                    id="productCategory"
                    value={productCategory}
                    onChange={(e) => setProductCategory(e.target.value)}
                    required
                  >
                    <option value="">Select Product Category</option>
                    {/* Add other product categories as needed */}
                    <option value="AC">AC</option>
                    <option value="LAPTOP">Laptop</option>
                    <option value="MICROWAVE">Microwave</option>
                    <option value="GEYSER">Geyser</option>
                    <option value="TV">TV</option>
                    <option value="WASHING MACHINE">Washing Machine</option>
                    <option value="FRIDGE">Fridge</option>
                    <option value="WATER PURIFIER">Water Purifier</option>
                    {/* ... */}
                  </select>
                  <div className="invalid-feedback">
                    {errors.productCategory}
                  </div>
                </div>
                <div className="col-md-6">
                  <label htmlFor="payment" className="form-label">
                    Payment Method
                  </label>
                  <select
                    className={`form-control ${
                      errors.payment ? "is-invalid" : ""
                    }`}
                    id="payment"
                    value={payment}
                    onChange={(e) => setPayment(e.target.value)}
                    required
                  >
                    <option value="">Select Payment Method</option>
                    <option value="COD">Cash on Delivery (COD)</option>
                    <option value="UPI">UPI</option>
                    {/* ... */}
                  </select>
                  <div className="invalid-feedback">{errors.payment}</div>
                </div>
              </div>

              <div className="mb-3">
                <label htmlFor="issueDescription" className="form-label">
                  Issue Description
                </label>
                <textarea
                  className={`form-control ${
                    errors.issueDescription ? "is-invalid" : ""
                  }`}
                  id="issueDescription"
                  placeholder="Enter the issue description"
                  value={issueDescription}
                  onChange={(e) => setIssueDescription(e.target.value)}
                  required
                />
                <div className="invalid-feedback">
                  {errors.issueDescription}
                </div>
              </div>

              {/* Add other sections and fields as needed */}

              <button type="submit" className="btn btn-primary w-100">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Order;
