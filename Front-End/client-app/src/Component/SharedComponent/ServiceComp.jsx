import React from "react";
import { Link } from "react-router-dom";
import ACimage1 from "../../Images/ACimage1.jpg";
import Laptopimage1 from "../../Images/Laptopimage1.jpg";
import Microwaveimage1 from "../../Images/Microwaveimage1.jpg";
import Geyserimage1 from "../../Images/Geyserimage1.jpg";
import TVimage1 from "../../Images/TVimage1.jpg";
import WashingMachineimage1 from "../../Images/WashingMachineimage1.jpg";
import WaterPurifierimage1 from "../../Images/WaterPurifierimage1.png";
import Fridgeimage1 from "../../Images/Fridgeimage1.jpg";

import "../../Css/ServiceComp.css"; // Import the CSS file for styling

function ServiceComp() {
  // Sample data for cards
  const cardsData = [
    {
      id: 1,
      title: "AC REPAIR",
      image: ACimage1,
      link: "/ACRepair",
    },
    {
      id: 2,
      title: "LAPTOP REPAIR",
      image: Laptopimage1,
      link: "/Laptop",
    },
    {
      id: 3,
      title: "MICROWAVE REPAIR",
      image: Microwaveimage1,
      link: "/Microwave",
    },
    {
      id: 4,
      title: "GEYSER REPAIR",
      image: Geyserimage1,
      link: "/Geyser",
    },

    {
      id: 5,
      title: "TV REPAIR",
      image: TVimage1,
      link: "/Television",
    },
    {
      id: 6,
      title: "WASHING M REPAIR",
      image: WashingMachineimage1,
      link: "/Washing",
    },
    // {
    //   id: 7,
    //   title: "FRIDGE REPAIR",
    //   image: Fridgeimage1,
    //   link: "/service3",
    // },
    // {
    //   id: 8,
    //   title: "PURIFIER REPAIR",
    //   image: WaterPurifierimage1,
    //   link: "/service4",
    // },
  ];

  return (
    <div className=" container row">
      {cardsData.map((card) => (
        <div key={card.id} className="col-md-4 mb-3">
          <div className="card">
            <img
              src={card.image}
              className="card-img-top"
              alt={card.title}
              style={{ height: "200px", objectFit: "cover" }}
            />
            <div className="card-body">
              <h5 className="card-title">{card.title}</h5>
              <Link to={card.link} className="btn btn-primary">
                Go to {card.title}
              </Link>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default ServiceComp;
