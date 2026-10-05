use std::io;
fn main(){
    let mut input = String::new();

    io::stdin().read_line(&mut input).unwrap();
    let a: i32 = input.trim().parse().unwrap();
    print!("{}", if a>=10&&a<=20 {"yes"} else {"no"});
}