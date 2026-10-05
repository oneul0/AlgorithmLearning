use std::io;
fn main(){
    let mut input = String::new();
    let mut input2 = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let a: f32 = input.trim().parse().unwrap();
    io::stdin().read_line(&mut input2).unwrap();
    let b: f32 = input2.trim().parse().unwrap();
    print!("{}", if a>=1.0&&b>=1.0 {"High"}
    else if a>=0.5&&b>=0.5 {"Middle"}
    else {"Low"});
}