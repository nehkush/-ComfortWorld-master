import React, { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import validateForm from "../../Js/ACRepairValidation.js"; // Import the validation logic
import "../../Css/ACRepair.css";
import ACInfoCards from "./ACInfoCards.jsx";
import { useNavigate } from "react-router-dom";

function ACRepair() {
  const [brand, setBrand] = useState("");
  const [model, setModel] = useState("");
  const [type, setType] = useState("");
  const [capacity, setCapacity] = useState("");
  const [hasRemoteControl, setHasRemoteControl] = useState("");
  const [price, setPrice] = useState("");
  const [isUnderWarranty, setIsUnderWarranty] = useState("");
  const [errors, setErrors] = useState({});
        const navigate=      useNavigate();
  const url = "http://localhost:8080";

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      brand,
      model,
      type,
      capacity,
      hasRemoteControl,
      price,
      isUnderWarranty,
    };

    const { isValid, errors: validationErrors } = validateForm(data);

    if (isValid) {
      axios
        .post(`${url}/airConditioners`, data)
        .then((response) => {
          const result = response.data;
          window.alert("Data submitted Successfully... ");
                 navigate("/Order")
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
        {/* Left side with ACInfoCards */}
        <div className="left-partition">
          <ACInfoCards />
          <ACInfoCards />
        </div>

        {/* Right side with registration form */}
        <div className="right-partition">
          <div className="card" style={{ width: "400px" }}>
            <div className="card-body">
              <h5 className="card-title text-center mb-4">
                Air Conditioner Form
              </h5>
              <form onSubmit={handleSubmit}>
                <div className="mb-3 ACRepairCSS">
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
                  <label htmlFor="model" className="form-label">
                    Model
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.model ? "is-invalid" : ""
                    }`}
                    id="model"
                    placeholder="Enter the model"
                    value={model}
                    onChange={(e) => setModel(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.model}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="type" className="form-label">
                    Type
                  </label>
                  <select
                    className={`form-control ${
                      errors.type ? "is-invalid" : ""
                    }`}
                    id="type"
                    value={type}
                    onChange={(e) => setType(e.target.value)}
                    required
                  >
                    <option value="">Select Type</option>
                    <option value="Split">Split</option>
                    <option value="Window">Window</option>
                    <option value="Central">Central</option>
                    {/* Add other options as needed */}
                  </select>
                  <div className="invalid-feedback">
                    Type must contain only letters and spaces.
                  </div>
                </div>

                <div className="mb-3">
                  <label htmlFor="capacity" className="form-label">
                    Capacity (BTU)
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.capacity ? "is-invalid" : ""
                    }`}
                    id="capacity"
                    placeholder="Enter the capacity"
                    value={capacity}
                    onChange={(e) => setCapacity(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.capacity}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="hasRemoteControl" className="form-label">
                    Has Remote Control
                  </label>
                  <select
                    className={`form-control ${
                      errors.hasRemoteControl ? "is-invalid" : ""
                    }`}
                    id="hasRemoteControl"
                    value={hasRemoteControl}
                    onChange={(e) => setHasRemoteControl(e.target.value)}
                    required
                  >
                    <option value="">Select</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <div className="invalid-feedback">
                    {errors.hasRemoteControl}
                  </div>
                </div>

                <div className="mb-3">
                  <label htmlFor="price" className="form-label">
                    Price
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.price ? "is-invalid" : ""
                    }`}
                    id="price"
                    placeholder="Enter the price"
                    value={price}
                    onChange={(e) => setPrice(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.price}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="isUnderWarranty" className="form-label">
                    Is Under Warranty
                  </label>
                  <select
                    className={`form-control ${
                      errors.isUnderWarranty ? "is-invalid" : ""
                    }`}
                    id="isUnderWarranty"
                    value={isUnderWarranty}
                    onChange={(e) => setIsUnderWarranty(e.target.value)}
                    required
                  >
                    <option value="">Select</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <div className="invalid-feedback">
                    {errors.isUnderWarranty}
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

export default ACRepair;
