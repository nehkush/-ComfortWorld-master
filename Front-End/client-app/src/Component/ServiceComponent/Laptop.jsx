// Laptop.js

import { useState } from "react";
import Navbar from "../SharedComponent/Navbar";
import axios from "axios";
import validateForm from "../../Js/LaptopValidation.js"; // Import the validation logic
import "../../Css/Laptop.css"; // Add the appropriate CSS file if needed

function Laptop() {
  const [brand, setBrand] = useState("");
  const [model, setModel] = useState("");
  const [processor, setProcessor] = useState("");
  const [ramSize, setRamSize] = useState(0);
  const [storageSize, setStorageSize] = useState(0);
  const [hasSSD, setHasSSD] = useState("");
  const [screenSize, setScreenSize] = useState(0);
  const [price, setPrice] = useState(0);
  const [isUnderWarranty, setIsUnderWarranty] = useState("");
  const [errors, setErrors] = useState({});

  const url = "http://localhost:8080";

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      brand,
      model,
      processor,
      ramSize,
      storageSize,
      hasSSD,
      screenSize,
      price,
      isUnderWarranty,
    };

    const { isValid, errors: validationErrors } = validateForm(data);

    if (isValid) {
      axios
        .post(`${url}/laptops`, data)
        .then((response) => {
          const result = response.data;
          window.alert("Data submitted Successfully... ");
          window.location.href = "/Issue";
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
        {/* Right side with registration form */}
        <div className="right-partition">
          <div className="card" style={{ width: "400px" }}>
            <div className="card-body">
              <h5 className="card-title text-center mb-4">Laptop Form</h5>
              <form onSubmit={handleSubmit}>
                <div className="mb-3 LaptopCSS">
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
                  <label htmlFor="processor" className="form-label">
                    Processor
                  </label>
                  <input
                    type="text"
                    className={`form-control ${
                      errors.processor ? "is-invalid" : ""
                    }`}
                    id="processor"
                    placeholder="Enter the processor"
                    value={processor}
                    onChange={(e) => setProcessor(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.processor}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="ramSize" className="form-label">
                    RAM Size (GB)
                  </label>
                  <input
                    type="number"
                    className={`form-control ${
                      errors.ramSize ? "is-invalid" : ""
                    }`}
                    id="ramSize"
                    placeholder="Enter the RAM size"
                    value={ramSize}
                    onChange={(e) => setRamSize(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.ramSize}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="storageSize" className="form-label">
                    Storage Size (GB)
                  </label>
                  <input
                    type="number"
                    className={`form-control ${
                      errors.storageSize ? "is-invalid" : ""
                    }`}
                    id="storageSize"
                    placeholder="Enter the storage size"
                    value={storageSize}
                    onChange={(e) => setStorageSize(e.target.value)}
                    required
                  />
                  <div className="invalid-feedback">{errors.storageSize}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="hasSSD" className="form-label">
                    Has SSD
                  </label>
                  <select
                    className={`form-control ${
                      errors.hasSSD ? "is-invalid" : ""
                    }`}
                    id="hasSSD"
                    value={hasSSD}
                    onChange={(e) => setHasSSD(e.target.value)}
                    required
                  >
                    <option value="">Select</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <div className="invalid-feedback">{errors.hasSSD}</div>
                </div>

                <div className="mb-3">
                  <label htmlFor="screenSize" className="form-label">
                    Screen Size (inches)
                  </label>
                  <input
                    type="number"
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
                  <label htmlFor="price" className="form-label">
                    Price
                  </label>
                  <input
                    type="number"
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

export default Laptop;
