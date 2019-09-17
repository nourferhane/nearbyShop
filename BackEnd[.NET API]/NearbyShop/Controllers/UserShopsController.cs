using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using NearbyShop.Models;

namespace NearbyShop.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserShopsController : ControllerBase
    {
        private readonly NearbyShopContext _context;

        public UserShopsController(NearbyShopContext context)
        {
            _context = context;
        }

        // GET: api/UserShops
        [HttpGet]
        public async Task<ActionResult<IEnumerable<UserShop>>> GetUserShop()
        {
            return await _context.UserShop.ToListAsync();
        }

        // GET: api/UserShops/5
        [HttpGet("{id}")]
        public async Task<ActionResult<UserShop>> GetUserShop(Guid id)
        {
            var userShop = await _context.UserShop.FindAsync(id);

            if (userShop == null)
            {
                return NotFound();
            }

            return userShop;
        }

        // PUT: api/UserShops/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutUserShop(Guid id, UserShop userShop)
        {
            if (id != userShop.shopId)
            {
                return BadRequest();
            }

            _context.Entry(userShop).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UserShopExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/UserShops
        [HttpPost]
        public async Task<ActionResult<UserShop>> PostUserShop(UserShop userShop)
        {
            _context.UserShop.Add(userShop);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (UserShopExists(userShop.shopId))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetUserShop", new { id = userShop.shopId }, userShop);
        }

        // DELETE: api/UserShops/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<UserShop>> DeleteUserShop(Guid id)
        {
            var userShop = await _context.UserShop.FindAsync(id);
            if (userShop == null)
            {
                return NotFound();
            }

            _context.UserShop.Remove(userShop);
            await _context.SaveChangesAsync();

            return userShop;
        }

        private bool UserShopExists(Guid id)
        {
            return _context.UserShop.Any(e => e.shopId == id);
        }
    }
}
