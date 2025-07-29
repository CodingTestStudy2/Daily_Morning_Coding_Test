/**
 * @param {number} n
 * @param {number} discount
 * @param {number[]} products
 * @param {number[]} prices
 */
var Cashier = function(n, discount, products, prices) { //생성자 함수
    this.n = n //할인을 적용하는 주기
    this.count = 0; //count 번째 고객
    this.discount= discount * 0.01 //할인율
    this.dict = {} //가격 저장
    for (let i = 0; i < products.length; i++) {
        this.dict[products[i]] = prices[i]
    }
};

/** 
 * @param {number[]} product 
 * @param {number[]} amount
 * @return {number}
 */
Cashier.prototype.getBill = function(product, amount) { //메서드
    this.count++ //현재 고객 번호 업데이트
    let res = 0;
    for (let i = 0; i < amount.length; i++) {
        res += this.dict[product[i]] * amount[i]
    } //가격 계산
    if (this.count % this.n === 0) {
        res = res - (res * this.discount)
    } // n 번째 고객이면 할인 적용 (값 - 할인율을 적용한 할인값)
    return res;
};

/** 
 * Your Cashier object will be instantiated and called as such:
 * var obj = new Cashier(n, discount, products, prices)
 * var param_1 = obj.getBill(product,amount)
 */