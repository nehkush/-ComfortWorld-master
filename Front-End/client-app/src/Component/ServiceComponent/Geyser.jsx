import React, { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import validateGeyserForm from "../../Js/GeyserValidation";
import "../../Css/Geyser.css";

const Geyser = () => {
  const [brand, setBrand] = useState("");
  const [model, setModel] = useState("");
  const [capacity, setCapacity] = useState("");
  const [hasThermostat, setHasThermostat] = useState("");
  const [price, setPrice] = useState("");
  const [isUnderWarranty, setIsUnderWarranty] = useState("");
  const [isServiceRequired, setIsServiceRequired] = useState("");
  const [errors, setErrors] = useState({});

  const url = "http://localhost:8080";

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      brand,
      model,
      capacity,
      hasThermostat,
      price,
      isUnderWarranty,
      isServiceRequired,
    };

    const { isValid, errors: validationErrors } = validateGeyserForm(data);

    if (isValid) {
      axios
        .post(`${url}/geysers`, data)
        .then((response) => {
          window.alert("Geyser data submitted successfully.");
          window.location.href = "/geyser";
        })
        .catch((error) => {
          console.error("Error in geyser form submission:", error);
        });
    } else {
      setErrors(validationErrors);
    }
  };

  return (
    <div>
      <div className="d-flex mt-3 justify-content-center">
        <div className="card" style={{ width: "400px" }}>
          <div className="card-body">
            <h5 className="card-title text-center mb-4">Geyser Form</h5>
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="brand" className="form-label">
                  Brand
                </label>
                <input
                  type="text"
                  className={`form-control ${errors.brand ? "is-invalid" : ""}`}
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
                  className={`form-control ${errors.model ? "is-invalid" : ""}`}
                  id="model"
                  placeholder="Enter the model"
                  value={model}
                  onChange={(e) => setModel(e.target.value)}
                  required
                />
                <div className="invalid-feedback">{errors.model}</div>
              </div>

              <div className="mb-3">
                <label htmlFor="capacity" className="form-label">
                  Capacity (Liters)
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
                <label htmlFor="hasThermostat" className="form-label">
                  Has Thermostat
                </label>
                <select
                  className={`form-control ${
                    errors.hasThermostat ? "is-invalid" : ""
                  }`}
                  id="hasThermostat"
                  value={hasThermostat}
                  onChange={(e) => setHasThermostat(e.target.value)}
                  required
                >
                  <option value="">Select</option>
                  <option value="Yes">Yes</option>
                  <option value="No">No</option>
                </select>
                <div className="invalid-feedback">{errors.hasThermostat}</div>
              </div>

              <div className="mb-3">
                <label htmlFor="price" className="form-label">
                  Price
                </label>
                <input
                  type="text"
                  className={`form-control ${errors.price ? "is-invalid" : ""}`}
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
                <div className="invalid-feedback">{errors.isUnderWarranty}</div>
              </div>

              <div className="mb-3">
                <label htmlFor="isServiceRequired" className="form-label">
                  Is Service Required
                </label>
                <select
                  className={`form-control ${
                    errors.isServiceRequired ? "is-invalid" : ""
                  }`}
                  id="isServiceRequired"
                  value={isServiceRequired}
                  onChange={(e) => setIsServiceRequired(e.target.value)}
                  required
                >
                  <option value="">Select</option>
                  <option value="Yes">Yes</option>
                  <option value="No">No</option>
                </select>
                <div className="invalid-feedback">
                  {errors.isServiceRequired}
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
  );
};

export default Geyser;
