import React, { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import validateTelevisionForm from "../../Js/TelevisionValidation";
import "../../Css/Television.css";

const Television = () => {
  const [brand, setBrand] = useState("");
  const [model, setModel] = useState("");
  const [type, setType] = useState("");
  const [screenSize, setScreenSize] = useState("");
  const [isSmartTV, setIsSmartTV] = useState("");
  const [isUnderWarranty, setIsUnderWarranty] = useState("");
  const [errors, setErrors] = useState({});

  const url = "http://localhost:8080";

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      brand,
      model,
      type,
      screenSize,
      isSmartTV,
      isUnderWarranty,
    };

    const { isValid, errors: validationErrors } = validateTelevisionForm(data);

    if (isValid) {
      axios
        .post(`${url}/televisions`, data)
        .then((response) => {
          window.alert("Television data submitted successfully.");
          window.location.href = "/Issue";
        })
        .catch((error) => {
          console.error("Error in television form submission:", error);
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
            <h5 className="card-title text-center mb-4">Television Form</h5>
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
                <label htmlFor="type" className="form-label">
                  Type
                </label>
                <input
                  type="text"
                  className={`form-control ${errors.type ? "is-invalid" : ""}`}
                  id="type"
                  placeholder="Enter the type"
                  value={type}
                  onChange={(e) => setType(e.target.value)}
                  required
                />
                <div className="invalid-feedback">{errors.type}</div>
              </div>

              <div className="mb-3">
                <label htmlFor="screenSize" className="form-label">
                  Screen Size (in inches)
                </label>
                <input
                  type="text"
                  className={`form-control ${
                    errors.screenSize ? "is-invalid" : ""
                  }`}
                  id="screenSize"
                  placeholder="Enter the screen size"
                  value={screenSize}
                  onChange={(e) => setScreenSize(e.target.value)}
                  required
                />
                <div className="invalid-feedback">{errors.screenSize}</div>
              </div>

              <div className="mb-3">
                <label htmlFor="isSmartTV" className="form-label">
                  Is Smart TV
                </label>
                <select
                  className={`form-control ${
                    errors.isSmartTV ? "is-invalid" : ""
                  }`}
                  id="isSmartTV"
                  value={isSmartTV}
                  onChange={(e) => setIsSmartTV(e.target.value)}
                  required
                >
                  <option value="">Select</option>
                  <option value="Yes">Yes</option>
                  <option value="No">No</option>
                </select>
                <div className="invalid-feedback">{errors.isSmartTV}</div>
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

export default Television;
