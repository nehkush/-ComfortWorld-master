import React from "react";

function ACInfoCards() {
  // Sample data for cards
  const infoData = [
    {
      id: 1,
      title: "Energy Efficiency",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    },
  ];

  return (
    <div className="  col mt-3 ml-3 ">
      {" "}
      {/* Added ml-auto class to move the cards to the left */}
      {infoData.map((info, index) => (
        <div
          key={info.id}
          className={`col-md-4 mb-3${index % 2 === 0 ? " offset-md-3" : ""}`}
        >
          <div className="card " style={{ width: "400px", height: "180px" }}>
            <div className="card-body">
              <h5 className="card-title">{info.title}</h5>
              <p className="card-text">{info.description}</p>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default ACInfoCards;
