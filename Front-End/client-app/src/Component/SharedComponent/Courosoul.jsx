import React from "react";
import cou1 from "../../Images/cou1.jpg";

import cou3 from "../../Images/cou3.jpg";
import cou4 from "../../Images/cou4.jpg";

import cou6 from "../../Images/cou6.jpg";
import "../../Css/Courosoul.css"; // Import the CSS file for styling

function Courosoul() {
  const carouselStyle = {
    height: "600px", // 30% of the viewport height
    width: "600px", // 100% of the viewport width
    margin: "auto",
  };

  return (
    <div>
      <div
        id="carouselExample"
        className="carousel slide"
        style={carouselStyle}
      >
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img src={cou1} className="d-block w-100" alt="..." />
          </div>

          <div className="carousel-item">
            <img src={cou3} className="d-block w-100" alt="..." />
          </div>
          <div className="carousel-item">
            <img src={cou4} className="d-block w-100" alt="..." />
          </div>

          <div className="carousel-item">
            <img src={cou6} className="d-block w-100" alt="..." />
          </div>
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExample"
          data-bs-slide="prev"
        >
          <span
            className="carousel-control-prev-icon"
            aria-hidden="true"
          ></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExample"
          data-bs-slide="next"
        >
          <span
            className="carousel-control-next-icon"
            aria-hidden="true"
          ></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  );
}

export default Courosoul;
