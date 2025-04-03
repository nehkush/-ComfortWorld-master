// ProductIssueForm.jsx

import React, { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import ACInfoCards from "./ACInfoCards.jsx";
import validateForm from "../../Js/ProductIssueValidation";
import "../../Css/ProductIssue.css"; // Add the appropriate CSS file if needed

function Issue() {
  const [category, setCategory] = useState("");
  const [brand, setBrand] = useState("");
  const [modelNumber, setModelNumber] = useState("");
  const [issueDescription, setIssueDescription] = useState("");
  const [errors, setErrors] = useState({});

  const url = "http://localhost:8080"; // Update the API endpoint

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      category,
      brand,
      modelNumber,
      issueDescription,
    };

    const { isValid, errors: validationErrors } = validateForm(data);

    if (isValid) {
      axios
        .post(`${url}/product-issues`, data) // Update the endpoint
        .then((response) => {
          const result = response.data;
          window.alert("Data submitted Successfully... ");
          window.location.href = "/payment"; // Update the redirect path
          console.log("Hello world");
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
      <div className="d-flex mt-3 ">
        <div className="left-partition">
          <ACInfoCards />
          <ACInfoCards />
        </div>
        <div className="right-partition">
          <div className="card" style={{ width: "400px" }}>
            <div className="card-body">
              <h5 className="card-title text-center mb-4">
                Product Issue Form
              </h5>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="category" className="form-label">
                    Category
                  </label>
                  <select
                    className={`form-control ${
                      errors.category ? "is-invalid" : ""
                    }`}
                    id="category"
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                    required
                  >
                    <option value="">Select Category</option>
                    <option value="AC">AC</option>
                    <option value="LAPTOP">Laptop</option>
                    <option value="MICROWAVE">Microwave</option>
                    <option value="GEYSER">Geyser</option>
                    <option value="TV">TV</option>
                    <option value="WASHING MACHINE">Washing Machine</option>
                    <option value="FRIDGE">Fridge</option>
                    <option value="WATER PURIFIER">Water Purifier</option>
                    {/* Add other options as needed */}
                  </select>
                  <div className="invalid-feedback">{errors.category}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="brand" className="form-label">
                    Brand
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.brand ? "is-invalid" : ""
                    }`}
                    id="brand"
                    placeholder="Enter the brand"
                    value={brand}
                    onChange={(e) => setBrand(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.brand}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="modelNumber" className="form-label">
                    Model Number
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.modelNumber ? "is-invalid" : ""
                    }`}
                    id="modelNumber"
                    placeholder="Enter the model number"
                    value={modelNumber}
                    onChange={(e) => setModelNumber(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.modelNumber}</div>
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

                <button type="submit" className="btn btn-primary w-100">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Issue;
