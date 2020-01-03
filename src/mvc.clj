(ns liquidity.controller
  (:import org.springframework.stereotype.Controller
            (org.springframework.web.bind.annotation RequestMapping RequestMethod ResponseBody))
  (:gen-class
    :name ^{Controller ""} ch.hedgesphere.liquidity.controller.LiquidityController
    :methods [[^{RequestMapping {:value ["/liquidity"] :method [RequestMethod/GET]} ResponseBody {}} hello [] String]]))

(defn -hello [this]
  "Hello world from a Clojure-based controller!")
