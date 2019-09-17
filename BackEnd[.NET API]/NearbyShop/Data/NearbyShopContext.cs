using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using NearbyShop.Models;

namespace NearbyShop.Models
{
    public class NearbyShopContext : DbContext
    {
        public NearbyShopContext (DbContextOptions<NearbyShopContext> options)
            : base(options)
        {
        }

        public DbSet<NearbyShop.Models.User> User { get; set; }

        public DbSet<NearbyShop.Models.Shop> Shop { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<UserShop>().HasKey(sc => new { sc.shopId, sc.userId });
        }
        public DbSet<NearbyShop.Models.UserShop> UserShop { get; set; }
    }
}
