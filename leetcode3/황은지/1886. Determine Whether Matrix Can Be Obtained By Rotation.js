/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
var findRotation = function(mat, target) {
    // 90도씩 돌려가면서 비교해보면 된다.
    const n=mat.length;
    let flag;
    for(let turn=0;turn<4;turn++){
        // 같은지 검사
        flag=true;
        for(let i=0;i<n;i++){
            for(let j=0;j<n;j++){
                if(mat[i][j]!==target[i][j]){
                    flag=false;
                    break;
                } 
            }
            if(!flag) break;
        }

        if(flag) return true;

        // 회전
        const temp=Array.from({length:n},()=>Array(n));
        for(let i=0;i<n;i++){
            for(let j=0;j<n;j++){
                temp[i][j]=mat[j][n-i-1];
            }
        }
        mat=temp;
    console.log(mat);
    }

    // 마지막 처리
    flag=true;
    for(let i=0;i<n;i++){
        for(let j=0;j<n;j++){
            if(mat[i][j]!==target[i][j]){
                flag=false;
                break;
            } 
        }
        if(!flag) break;
    }

    return flag;
};