import React from 'react'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import { topMeels } from './topMeels';
import CarouselItem from './CarouselItem';




const MultiitemCarousel = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 1,
    autoplay:true,
    autoplaySpeed:2000,
    arrows:false
  };
  return (
    <div>
         <Slider {...settings}>

{topMeels.map((item , i) => (
            <CarouselItem image={item.image} title={item.title} key={i}/>
))}    
        </Slider>

    </div>
  )
}

export default MultiitemCarousel