using Microsoft.AspNetCore.Mvc;

namespace ISDocker.Controllers;

[ApiController]
[Route("[controller]")]
public class MoneyController : ControllerBase
{

    public MoneyController()
    {
        
    }

    [Route("{price}/{hasParts}")]
    [HttpGet]
    public async Task<ActionResult> Get(int price, int hasParts)
    {
        if(hasParts > 0) {
            Random objRnd = new Random();
            int hasPartsPrice = objRnd.Next(hasParts*10, hasParts*1000);
            return await Task.FromResult(Ok(hasPartsPrice + price));
        } else 
            return await Task.FromResult(Ok(price)); 

    }
}
