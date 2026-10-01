use std::io;

fn main() {
    let mut input1 = String::new();
    let mut input2 = String::new();

    io::stdin().read_line(&mut input1).unwrap();
    let a: i32 = input1.trim().parse().unwrap();

    io::stdin().read_line(&mut input2).unwrap();

    let nums: Vec<i32> = input2
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    let b = nums[0];
    let c = nums[1];
    let d = nums[2];
    let e = nums[3];

    println!("{}", if a > b { 1 } else { 0 });
    println!("{}", if a > c { 1 } else { 0 });
    println!("{}", if a > d { 1 } else { 0 });
    println!("{}", if a > e { 1 } else { 0 });
}