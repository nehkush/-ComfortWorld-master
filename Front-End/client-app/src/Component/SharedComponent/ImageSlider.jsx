import React from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css' ;
import 'slick-carousel/slick/slick-theme.css';
import img1 from '../../Images/contact.png' ;
import img2 from '../../Images/Electrician_Big1.jpg';
import img3 from '../../Images/Electrician_Big4.jpg';


const ImageSlider = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 700,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 1300,
  };

  return (
    <div style={{ textAlign: 'center' }}>
      <Slider {...settings}>
        <div>
          <img src={img1} alt="Image 1" style={{ margin: '0 auto ' }} />
        </div>
        <div>
          <img src={img2} alt="Image 2" style={{ margin: ' 0 auto' }} />
        </div>
        <div>
          <img src={img3} alt="Image 3" style={{ margin: ' 0 auto ' }} />
        </div>
      </Slider>
    </div>
  );
};

export default ImageSlider;